/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entities.Category;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Celia Navarro Pérez
 */
@Stateless
public class CategoryFacade extends AbstractFacade<Category> {

    @PersistenceContext(unitName = "GestionDeCitas_Local1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }

    public List<Category> search(String description) {
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Category> cq = qb.createQuery(Category.class);

        Root<Category> categories = cq.from(Category.class);
        cq.select(categories).where(qb.like(categories.get("description"), "%" + description + "%"));

        List<Category> search_results = em.createQuery(cq).getResultList();
        return search_results;
    }

}
