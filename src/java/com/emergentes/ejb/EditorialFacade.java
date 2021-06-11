/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.ejb;

import com.emergentes.entidades.Editorial;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorge
 */
@Stateless
public class EditorialFacade extends AbstractFacade<Editorial> {
    @PersistenceContext(unitName = "TE_participacion_8_junioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EditorialFacade() {
        super(Editorial.class);
    }
    
}
