package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdController {
    private AdsRepository adsDao;
    private UsersRepository usersDao;
    private User usersAd;

    public AdController(AdsRepository adsRepository, UsersRepository usersRepository){
        adsDao = adsRepository;
        usersDao = usersRepository;
    }

//    public String save(@RequestParam(value = "title") String title);

    @GetMapping("/ads")
    public String index(Model model) {
        List<Ad> adsList = adsDao.findAll();
        model.addAttribute("noAdsFound", adsList.size() == 0);
        model.addAttribute("ads", adsList);
        model.addAttribute("topAd", adsDao.findByTitle("bicycle north side"));
        model.addAttribute("searchAd", adsDao.findByTitleLike("%childcare%"));
        return "ad-index";
    }


    @GetMapping("/ads")
    public String index(@PathVariable List<Ad> ad, Model model){
        List<Ad> adsList = adsDao.findAll();
        model.addAttribute("noAdsFound", adsList.size() == 0);
        model.addAttribute("ads", adsList);
        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    public String show(@PathVariable long id, Model model){
        model.addAttribute("adId", id);
        model.addAttribute("ad", adsDao.getById(id));
        return "ads/show";
    }

    @GetMapping("/ads/create")
    public String showForm(){
        return "ads/create";
    }

//    @PostMapping("/ads/create")
//    public String save(@RequestParam(value = "title") String title,
//                       @RequestParam(value = "description") String description){
//        User user = user.getById(1L);
//        Ad newAd = new Ad(title, description, User);
//        Ad savedAd = adsDao.save(newAd);
//        return "redirect:/ads/" + savedAd.getId();
//    }

    @GetMapping("/ads/{id}/edit")
    public String showEditForm(Model model, @PathVariable long id){
        // find an ad
        Ad adToEdit = adsDao.getById(id);
        model.addAttribute("ad", adToEdit);
        return "ads/edit";
    }

    @PostMapping("/ads/{id}/edit")
    @ResponseBody
    public String update(@PathVariable long id,
                         @RequestParam(name = "title") String title,
                         @RequestParam(name = "description") String desc){
        // find an ad
        Ad foundAd = adsDao.getById(id); // select * from ads where id = ?
        // edit the ad
        foundAd.setTitle(title);
        foundAd.setDescription(desc);
        // save the changes
        adsDao.save(foundAd); // update ads set title = ? where id = ?
        return "ad updated";
    }

    @PostMapping("/ads/{id}/delete")
    public String destroy(@PathVariable long id){
        adsDao.deleteById(id);
        return "redirect:/ads";
    }

    @GetMapping("/search")
    public String searchResults(Model model, @RequestParam(name = "term") String term){
        List<Ad> ads = adsDao.searchByTitle(term);
        model.addAttribute("ads", ads);
        return "ads/index";
    }


}
