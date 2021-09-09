package controller;

import com.promotion.dto.PromotionDto;
import com.promotion.model.Promotion;
import com.promotion.service.GenericService;
import com.promotion.service.PromotionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promotion/{birthday}")
public class PromotionController extends GenericController<Promotion, PromotionDto>{
    private PromotionService service;

    public PromotionController(PromotionService service) {
        this.service = service;
    }
    @Override
    protected GenericService getService() {
        return (GenericService) service;
    }
}
