package com.klutzynome.controller;

import com.klutzynome.model.Input;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @PostMapping("/submitted") // handle the register endpoint from the html form
    public String handleInput(@ModelAttribute Input input, Model model) {
        // user would have already ticked the boxes
        if (!input.isValidColor()) {
            model.addAttribute("result","");
            model.addAttribute("error","That's not a valid hex color");
        } else {
            String complimentaryResult = "";
            String[] monochromeResult = new String[5];
            if (input.getComplimentarySelection()) {
                complimentaryResult = input.handleComplimentSelection();
            }
            if (input.getMonochromeSelection()) {
                monochromeResult = input.handleMonochromeResult();
            }


            model.addAttribute("colorblindOpt", input.hasColorblindOpt());

            System.out.println("Protanopia: "+ input.getColorblindOpt());

            model.addAttribute("complimentaryRectColor", "#"+complimentaryResult);
            model.addAttribute("complimentaryResult", complimentaryResult);
            model.addAttribute("complimentaryBoxTicked", input.getComplimentarySelection());

            model.addAttribute("monochromeBoxTicked", input.getMonochromeSelection());
            System.out.println("monochrome res 0: " + monochromeResult[0]);
            model.addAttribute("monoRectColor0", "#"+monochromeResult[0]);
            model.addAttribute("monoRectColor1", "#"+monochromeResult[1]);
            model.addAttribute("monoRectColor2", "#"+monochromeResult[2]);
            model.addAttribute("monoRectColor3", "#"+monochromeResult[3]);
            model.addAttribute("monoRectColor4", "#"+monochromeResult[4]);
        }
        return "index"; // return the same page
    }

    private void handleResultAttributes(String complimentaryResult, String monochromeResult) {
    }
}
