//package sia.tacocloud.tacos.web;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.support.SessionStatus;
//import sia.tacocloud.tacos.Order;
//import sia.tacocloud.tacos.User;
//import sia.tacocloud.tacos.data.jpa.OrderRepository;
//
//import javax.validation.Valid;
//
//@Slf4j
//@Controller
//@RequestMapping(value = "/orders")
//@SessionAttributes("order")
//public class OrderController {
//    private final OrderRepository orderRepo;
//    private final OrderProps orderProps;
//
//    public OrderController(OrderRepository orderRepo, OrderProps orderProps) {
//        this.orderRepo = orderRepo;
//        this.orderProps = orderProps;
//    }
//
//    @GetMapping("/current")
//    public String orderForm() {
//        return "orderForm";
//    }
//
//    @PostMapping
//    public String processOrder(@Valid Order order,
//                               Errors errors,
//                               SessionStatus sessionStatus,
//                               @AuthenticationPrincipal User user) {
//        if (errors.hasErrors()) {
//            return "orderForm";
//        }
//        order.setUser(user);
//        orderRepo.save(order);
//        sessionStatus.setComplete();
//
//        return "redirect:/";
//    }
//
//    @GetMapping
//    public String ordersForUser(@AuthenticationPrincipal User user,
//                                Model model) {
//
//        //set pageable object
//        Pageable pageable = PageRequest.of(0, orderProps.getPageSize());
//        //make response available to thymeleaf for display in html page
//        model.addAttribute("orders", orderRepo.findByUserOrderByPlacedAtDesc(user, pageable));
//
//        return "orderList";
//    }
//}