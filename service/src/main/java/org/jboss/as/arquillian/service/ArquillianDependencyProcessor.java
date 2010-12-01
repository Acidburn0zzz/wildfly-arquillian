/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.arquillian.service;

import org.jboss.as.deployment.module.ModuleConfig;
import org.jboss.as.deployment.module.ModuleDependencies;
import org.jboss.as.deployment.unit.DeploymentUnitContext;
import org.jboss.as.deployment.unit.DeploymentUnitProcessingException;
import org.jboss.as.deployment.unit.DeploymentUnitProcessor;
import org.jboss.modules.ModuleIdentifier;

/**
 * Service responsible for creating and managing the life-cycle of the Arquillian service.
 *
 * @author <a href="kabir.khan@jboss.com">Kabir Khan</a>
 * @version $Revision: 1.1 $
 */
public class ArquillianDependencyProcessor implements DeploymentUnitProcessor {

    private static ModuleIdentifier JBOSS_ARQUILLIAN_API_ID     = ModuleIdentifier.create("org.jboss.arquillian.api");
    private static ModuleIdentifier JBOSS_ARQUILLIAN_JUNIT_ID   = ModuleIdentifier.create("org.jboss.arquillian.junit");
    private static ModuleIdentifier JBOSS_ARQUILLIAN_SPI_ID     = ModuleIdentifier.create("org.jboss.arquillian.spi");
    private static ModuleIdentifier JBOSS_LOGGING_ID            = ModuleIdentifier.create("org.jboss.logging");
    private static ModuleIdentifier JBOSS_MODULES_ID            = ModuleIdentifier.create("org.jboss.modules");
    private static ModuleIdentifier JBOSS_SHRINKWRAP_API_ID     = ModuleIdentifier.create("org.jboss.shrinkwrap.api");
    private static ModuleIdentifier JUNIT_JUNIT_API_ID          = ModuleIdentifier.create("junit.junit");


    @Override
    public void processDeployment(DeploymentUnitContext context) throws DeploymentUnitProcessingException {
        if (context.getAttachment(ArquillianConfig.ATTACHMENT_KEY) == null) {
            return;
        }

        ModuleDependencies.addDependency(context, new ModuleConfig.Dependency(JBOSS_ARQUILLIAN_API_ID, true, false, false));
        ModuleDependencies.addDependency(context, new ModuleConfig.Dependency(JBOSS_ARQUILLIAN_JUNIT_ID, true, false, false));
        ModuleDependencies.addDependency(context, new ModuleConfig.Dependency(JBOSS_ARQUILLIAN_SPI_ID, true, false, false));
        ModuleDependencies.addDependency(context, new ModuleConfig.Dependency(JBOSS_LOGGING_ID, true, false, false));
        ModuleDependencies.addDependency(context, new ModuleConfig.Dependency(JBOSS_MODULES_ID, true, false, false));
        ModuleDependencies.addDependency(context, new ModuleConfig.Dependency(JBOSS_SHRINKWRAP_API_ID, true, false, false));
        ModuleDependencies.addDependency(context, new ModuleConfig.Dependency(JUNIT_JUNIT_API_ID, true, false, false));
    }

}
