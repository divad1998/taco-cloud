//package sia.tacocloud;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest
//public class HomeControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test //prompts creation of App Context
//    public void contextLoads() {
//    }
//
//    @Test
//    public void testHomeController() throws Exception {
//
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk()) //expect 200 status code
//                .andExpect(view().name("home")) //expect view logical name is "home"
//                .andExpect(content().string(containsString("Welcome to..."))); //page content contains the given string
//    }
//}
