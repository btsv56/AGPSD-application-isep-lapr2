/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import lapr.project.autorization.AuthorizationFacade;
import lapr.project.autorization.model.UserSession;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Constants;

/**
 *
 * @author paulomaio
 */
public class AppGPSD {

    private Company m_oCompany;
    private final AuthorizationFacade m_oAutorization;

    private AppGPSD() {
        Properties props = getProperties();
        try {
            this.m_oCompany = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION),
                    props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        } catch (IOException ioe) {
            System.exit(1);
        }
        this.m_oCompany.getServiceTypesRecords().createsServiceTypesSupported(props);
        this.m_oCompany.getFormatTypeRecords().createsFormatTypesSupported(props);
        this.m_oAutorization = this.m_oCompany.getClientRecords().getAutorizacaoFacade();
        bootstrap();
    }

    public Company getCompany() {
        return this.m_oCompany;
    }

    public UserSession getCurrentSession() {
        return this.m_oAutorization.getCurrentSession();
    }

    public boolean doLogin(String strId, String strPwd) {
        return this.m_oAutorization.doLogin(strId, strPwd) != null;
    }

    public void doLogout() {
        this.m_oAutorization.doLogout();
    }

    public Properties getProperties() {
        Properties props = new Properties();

        // Adiciona propriedades e valores por omissão
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Default Lda.");
        props.setProperty(Constants.PARAMS_COMPANY_TIN, "Default NIF");

        // Lê as propriedades e valores definidas
        try {
            InputStream in = new FileInputStream(Constants.PARAMS_FILE);
            props.load(in);
            in.close();
        } catch (Exception ex) {

        }
        return props;
    }

    private void bootstrap() {
        this.m_oAutorization.registerUserPaper(Constants.PAPER_ADMINISTRATOR);
        this.m_oAutorization.registerUserPaper(Constants.PAPER_CLIENT);
        this.m_oAutorization.registerUserPaper(Constants.PAPEL_HRO);
        this.m_oAutorization.registerUserPaper(Constants.PAPER_SERVICE_PROVIDER);

        this.m_oAutorization.registerUserWithPaper("Administrativo 1", "adm1@esoft.pt", "123456", Constants.PAPER_ADMINISTRATOR);
        this.m_oAutorization.registerUserWithPaper("Administrativo 2", "adm2@esoft.pt", "123456", Constants.PAPER_ADMINISTRATOR);

        this.m_oAutorization.registerUserWithPaper("FRH 1", "frh1@esoft.pt", "123456", Constants.PAPEL_HRO);
        this.m_oAutorization.registerUserWithPaper("FRH 2", "frh2@esoft.pt", "123456", Constants.PAPEL_HRO);

//        this.m_oAutorization.registerUserWithPaper("Cliente 1", "client", "123", Constants.PAPER_CLIENT); //to remove later

//        this.m_oAutorization.registerUserWithPaper("SP", "SP", "SP", Constants.PAPER_SERVICE_PROVIDER);
        this.m_oAutorization.registerUserWithPapers("Martim", "martim@esoft.pt", "123456", new String[]{Constants.PAPEL_HRO, Constants.PAPER_ADMINISTRATOR});
    }

    // Inspirado em https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static AppGPSD singleton = null;

    public static AppGPSD getInstance() {
        if (singleton == null) {
            synchronized (AppGPSD.class) {
                singleton = new AppGPSD();
            }
        }
        return singleton;
    }

}
