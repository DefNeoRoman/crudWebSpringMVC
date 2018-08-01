package app.db;

import app.model.User;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.util.StringUtils;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class HibernateConfig {
    public static final EntityManager em = createEntityManager();

    public static EntityManager getEm() {
        return em;
    }

    public static EntityManager createEntityManager() {

        InputStream inputStream = HibernateConfig.class.getClassLoader().getResourceAsStream("app.properties");
        final Properties props = new Properties();
        Properties inputProperties = new Properties();
        try {
            inputProperties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        props.put("hibernate.connection.url", inputProperties.get("url"));
        props.put("hibernate.connection.username", inputProperties.get("user"));
        props.put("hibernate.connection.driver_class",inputProperties.getProperty("driver"));
        props.put("hibernate.connection.password", inputProperties.get("password"));
        PersistenceUnitInfo persistenceUnitInfo = new PersistenceUnitInfo() {

            @Override
            public Properties getProperties() {
                return props;
            }

            @Override
            public List<String> getManagedClassNames() {
                return Arrays.asList(User.class.getName());
            }

            @Override
            public String getPersistenceUnitName() {
                return "model";
            }

            @Override
            public String getPersistenceProviderClassName() {
                return HibernatePersistenceProvider.class.getName();
            }

            @Override
            public PersistenceUnitTransactionType getTransactionType() {
                return null;
            }

            @Override
            public DataSource getJtaDataSource() {
                return null;
            }

            @Override
            public DataSource getNonJtaDataSource() {
                return null;
            }

            @Override
            public List<String> getMappingFileNames() {
                return null;
            }

            @Override
            public List<URL> getJarFileUrls() {
                return null;
            }

            @Override
            public URL getPersistenceUnitRootUrl() {
                return null;
            }

            @Override
            public boolean excludeUnlistedClasses() {
                return false;
            }

            @Override
            public SharedCacheMode getSharedCacheMode() {
                return null;
            }

            @Override
            public ValidationMode getValidationMode() {
                return null;
            }

            @Override
            public String getPersistenceXMLSchemaVersion() {
                return null;
            }

            @Override
            public ClassLoader getClassLoader() {
                return null;
            }

            @Override
            public void addTransformer(ClassTransformer transformer) {

            }

            @Override
            public ClassLoader getNewTempClassLoader() {
                return null;
            }
        };

        HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();

        EntityManagerFactory entityManagerFactory = hibernatePersistenceProvider
                .createContainerEntityManagerFactory(persistenceUnitInfo, Collections.EMPTY_MAP);

        return entityManagerFactory.createEntityManager();
    }
}
