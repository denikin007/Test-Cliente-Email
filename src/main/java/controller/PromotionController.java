package controller;

import com.promotion.dto.PromotionDto;
import com.promotion.model.Promotion;
import com.promotion.service.GenericService;
import com.promotion.service.PromotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promotion")
public class PromotionController extends GenericController<Promotion, PromotionDto>{
    private PromotionService service;

    public PromotionController(PromotionService service) {
        this.service = service;
    }
    @Override
    protected GenericService getService() {
        return (GenericService) service;
    }

    @GetMapping(value = "/promotion/birthday/{idPromotion}")
    public void getBirthday(@PathVariable("idPromotion") Long idPromotion) {
        service.sendMessage(idPromotion);
    }
}
