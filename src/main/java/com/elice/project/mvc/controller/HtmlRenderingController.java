package com.elice.project.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlRenderingController {
  @GetMapping
  public String getHtml(Model model) {
    return "index";
  }
}
