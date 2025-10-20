package iuh.fit.se.controllers;

import iuh.fit.se.entity.DienThoai;
import iuh.fit.se.entity.NhaCungCap;
import iuh.fit.se.services.DienThoaiService;
import iuh.fit.se.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NhaCungCapController {

    @Autowired
    DienThoaiService dienThoaiService;

    @Autowired
    private NhaCungCapService nhaCungCapService;

    @GetMapping("/danh-sach-ncc")
    public String listNhaCungCap(Model model,
                                 @RequestParam(value = "keyword", required = false) String keyword){

        List<NhaCungCap> nhaCungCaps;

        if (keyword != null && !keyword.isEmpty()) {
            nhaCungCaps = nhaCungCapService.searchNhaCungCap(keyword);
        } else {
            nhaCungCaps = nhaCungCapService.findAll();
        }

        model.addAttribute("nhacungcap", nhaCungCaps);
        return "DanhSachDienThoaiNCC";
    }
}