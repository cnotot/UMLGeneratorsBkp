/*******************************************************************************
 * Copyright (c) 2012, 2014 CNES and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Cedric Notot (Obeo) - initial API and implementation
 *******************************************************************************/
package org.eclipse.umlgen.dsl.eth.presentation.custom;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.umlgen.dsl.asl.presentation.custom.CustomAslAdapterFactoryContentProvider;

/**
 * Specific factory to rout to its own descriptor.
 *
 * @author cnotot
 */
public class CustomEthAdapterFactoryContentProvider extends CustomAslAdapterFactoryContentProvider {

    /**
     * Constructor.
     *
     * @param adapterFactory
     *            The adapter factory.
     */
    public CustomEthAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.umlgen.dsl.asl.presentation.custom.CustomAslAdapterFactoryContentProvider#createPropertySource(java.lang.Object,
     *      org.eclipse.emf.edit.provider.IItemPropertySource)
     */
    @Override
    protected IPropertySource createPropertySource(Object object, IItemPropertySource itemPropertySource) {
        // TODO Auto-generated method stub
        return new CustomEthPropertySource(object, itemPropertySource);
    }

}
