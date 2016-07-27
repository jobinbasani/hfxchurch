package org.jb.test.services;

import org.jb.config.AppConfig;
import org.jb.service.FamilyService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static util.Constants.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public abstract class BaseTestCase {

    public BaseTestCase() {
        if (!System.getProperties().contains(OPENSHIFT_POSTGRESQL_DB_HOST)) {
            System.getProperties().setProperty(OPENSHIFT_POSTGRESQL_DB_HOST, DEFAULT_DB_HOST);
        }
        if (!System.getProperties().contains(OPENSHIFT_POSTGRESQL_DB_PORT)) {
            System.getProperties().setProperty(OPENSHIFT_POSTGRESQL_DB_PORT, DEFAULT_DB_PORT);
        }
    }

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    protected String getResponseBody(String path) throws Exception {
        MvcResult result = getMockMvc().perform(get(path)
                .accept(APPLICATION_JSON)).
                andExpect(status().isOk())
                .andReturn();
        return result.getResponse().getContentAsString();
    }

    protected FamilyService getFamilyService(){
        return wac.getBean(FamilyService.class);
    }

}
