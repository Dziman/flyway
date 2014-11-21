/**
 * Copyright 2010-2014 Axel Fontaine
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//
// Project: flyway
//
// Media-Saturn IT Services GmbH
//
// Wankelstr. 5
// 85046 Ingolstadt
// Telefon: +49 (841) 634-0
// Telefax: +49 (841) 634-992596
// Web:     www.media-saturn.com
//

package org.flywaydb.core.internal.dbsupport.solid;

import org.flywaydb.core.DbCategory;
import org.flywaydb.core.internal.util.jdbc.DriverDataSource;
import org.flywaydb.core.migration.MigrationTestCase;
import org.junit.experimental.categories.Category;

import javax.sql.DataSource;
import java.util.Properties;

@Category(DbCategory.SolidDB.class)
public class SolidMigrationMediumTest extends MigrationTestCase {
    @Override
    protected DataSource createDataSource(final Properties customProperties) throws Exception {
        final String user = customProperties.getProperty("solid.user", "flyway");
        final String password = customProperties.getProperty("solid.password", "flyway");
        final String url = customProperties.getProperty("solid.url", "jdbc:solid://localhost:1313");

        return new DriverDataSource(Thread.currentThread().getContextClassLoader(), "solid.jdbc.SolidDriver",
                                    url, user, password);
    }

    @Override
    protected String getQuoteLocation() {
        return "migration/quote";
    }
}
