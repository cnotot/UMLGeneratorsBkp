/*******************************************************************************
 * Copyright (c) 2010, 2014 CS Systèmes d'Information (CS-SI).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sebastien Gabel (CS-SI) - initial API and implementation
 *     Cedric Notot (Obeo) - evolutions to cut off from diagram part
 *******************************************************************************/
package org.eclipse.umlgen.reverse.c.event;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;
import org.eclipse.umlgen.c.common.interactions.SynchronizersManager;
import org.eclipse.umlgen.c.common.interactions.extension.IDiagramSynchronizer;
import org.eclipse.umlgen.c.common.interactions.extension.IModelSynchronizer;
import org.eclipse.umlgen.c.common.util.ModelManager;
import org.eclipse.umlgen.c.common.util.ModelUtil;
import org.eclipse.umlgen.c.common.util.ModelUtil.EventType;

/**
 * Event related to a deletion of a macro.
 *
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 * @author <a href="mailto:christophe.le-camus@c-s.fr">Christophe LE CAMUS</a>
 */
public class MacroRemoved extends AbstractMacroEvent {

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.umlgen.reverse.c.event.AbstractCModelChangedEvent#notifyChanges(org.eclipse.umlgen.c.common.util.ModelManager)
     */
    @Override
    public void notifyChanges(ModelManager manager) {
        Classifier matchingClassifier = ModelUtil.findClassifierInPackage(manager.getSourcePackage(),
                getUnitName());
        Property attribute = matchingClassifier.getAttribute(getCurrentName(), null);

        if (attribute != null) {
            if (ModelUtil.isRemovable(attribute)) {
                IModelSynchronizer synchronizer = SynchronizersManager.getSynchronizer();
                if (synchronizer instanceof IDiagramSynchronizer) {
                    ((IDiagramSynchronizer)synchronizer).removeRepresentation(attribute, manager);
                }
                attribute.destroy();
            } else {
                ModelUtil.setVisibility(attribute, getTranslationUnit(), EventType.REMOVE);
            }
        }
    }

    /**
     * Gets the right builder.
     *
     * @return the builder for this event
     */
    public static AbstractBuilder<MacroRemoved> builder() {
        return new AbstractBuilder<MacroRemoved>() {
            private MacroRemoved event = new MacroRemoved();

            /**
             * @see org.eclipse.umlgen.reverse.c.MacroBuilder#getEvent()
             */
            @Override
            protected MacroRemoved getEvent() {
                return event;
            }
        };
    }
}
