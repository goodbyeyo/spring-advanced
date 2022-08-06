package study.springadvanced.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service    // @Component 어노테이션 포함하고 있기때문에 스캔대상이 되고 자동으로 스프링 빈에 등록됌
@RequiredArgsConstructor  // 생성자 자동으로 생성
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepository;

    // 생성자가 1개만 있으면 자동으로 Autowired가 붙게 된다. 따라서 자동으로 의존관계 주입
//    @Autowired    
//    public OrderServiceV0(OrderRepositoryV0 orderRepository) {
//        this.orderRepository = orderRepository;
//    }

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }


    
}
