/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import sn.auth.Authentification;
import sn.grh.Accesgroupe;
import sn.grh.Utilisateur;

/**
 *
 * @author fallougalass
 */
@Stateless
@Path("sn.grh.utilisateur")
public class UtilisateurFacadeREST extends AbstractFacade<Utilisateur> {

    @EJB
    private AccesgroupeFacadeREST accesgroupeFacadeREST;

    @PersistenceContext(unitName = "ProjetGRHPU")
    private EntityManager em;
    
    @Context private HttpServletRequest request;
    
    public UtilisateurFacadeREST() {
        super(Utilisateur.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Utilisateur entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Utilisateur entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Utilisateur find(@PathParam("id") Integer id) {
        
        return super.find(id);
    }
    
    @GET
    @Path("employe/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Utilisateur findByEmploye(@PathParam("id") Integer id) {
        
        List<Utilisateur> u=em.createQuery("SELECT u FROM Utilisateur u WHERE u.employe.id=:id", Utilisateur.class)
                .setParameter("id", id)
                .getResultList();
        if(u.size()>0){
           return u.get(0);
        }
        return null;
    }
    
    @GET
    @Path("avatar/{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public String findAvatar(@PathParam("id") Integer id) {
        String s=em.createQuery("SELECT u.avatar FROM Utilisateur u WHERE u.employe.id=:id", String.class)
                .setParameter("id", id)
                .getSingleResult();
        if(s==null || s.equals("")){
            s="images/avatar.png";
        }
        return s;
    }
    
    @GET
    @Path("login/{login}/password/{motDePasse}")
    @Produces({MediaType.APPLICATION_JSON})
    public Utilisateur login(@PathParam("login") String login,@PathParam("motDePasse") String motDePasse) {
        List<Utilisateur> u=em.createQuery("SELECT u FROM Utilisateur u WHERE u.login = :login AND u.motDePasse = :motDePasse", Utilisateur.class)
                .setParameter("login", login)
                .setParameter("motDePasse", motDePasse)
                .getResultList();
        
        
        
        if(u.size()>0){
            
            registerAccess(u.get(0));
            return u.get(0);
        }
        return null;
    }
    
    @GET
    @Path("deconnexion")
    @Produces({MediaType.TEXT_PLAIN})
    public String logout() {
        System.out.println("*********DECONNEXION*********");

        if(Authentification.sessionDestroy()){
            return "success";
        }   
        
        return "fail";

    }
    
    public void registerAccess(Utilisateur user){
        
//        HttpSession session=request.getSession(true);
//        session.setAttribute("user", user);          
//        List<Accesgroupe> access=accesgroupeFacadeREST.findAllForGroup(user.getGroupe().getId());      
//        HashMap<String,Boolean> permissionTable;
//        for(int i=0;i<access.size();i++){
//            permissionTable=new HashMap<>();
//            permissionTable.put("ajouter", access.get(i).getAjouter());
//            permissionTable.put("modifier", access.get(i).getModifier());
//            permissionTable.put("supprimer", access.get(i).getSupprimer());
//            permissionTable.put("consulter", access.get(i).getConsulter());
//            permissionTable.put("lister", access.get(i).getLister());
//            
//            session.setAttribute(access.get(i).getNomTable(), permissionTable);
//
//        } 

        HttpSession session=request.getSession(true);
        
        Authentification.setSession(session);      
        Authentification.setData("user", user);
        
        List<Accesgroupe> access=accesgroupeFacadeREST.findAllForGroup(user.getGroupe().getId());      
        HashMap<String,Boolean> permissionTable;
        for(int i=0;i<access.size();i++){
            permissionTable=new HashMap<>();
            permissionTable.put("ajouter", access.get(i).getAjouter());
            permissionTable.put("modifier", access.get(i).getModifier());
            permissionTable.put("supprimer", access.get(i).getSupprimer());
            permissionTable.put("consulter", access.get(i).getConsulter());
            permissionTable.put("lister", access.get(i).getLister());
            
            Authentification.setData(access.get(i).getNomTable(), permissionTable);
        } 
        
        if(Authentification.sessionExist()){
            System.out.println("*****************La session existe*************");
        }
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Utilisateur> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Utilisateur> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
