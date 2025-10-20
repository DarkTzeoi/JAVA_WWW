package iuh.fit.se.controllers;

import iuh.fit.se.entity.DienThoai;
import iuh.fit.se.services.DienThoaiService;
import iuh.fit.se.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.List;

@Controller
public class DienThoaiController {

    private final DienThoaiService dienThoaiService;

    private final NhaCungCapService nhaCungCapService;
    @Autowired
    public DienThoaiController(NhaCungCapService nhaCungCapService, DienThoaiService dienThoaiService){
        this.dienThoaiService = dienThoaiService;
        this.nhaCungCapService = nhaCungCapService;
    }
    @GetMapping("/danh-sach-dt")
    public String listDienThoaiByNCC(Model model, @RequestParam("maNCC") String maNCC) {
        List<DienThoai> dienThoaiList = dienThoaiService.findByMaNCC(maNCC);
        model.addAttribute("dienThoaiList", dienThoaiList);
        return "DanhSachDienThoai";
    }

    @GetMapping("/them-moi-dt")
    public String showAddForm(Model model) {
        model.addAttribute("dienThoai", new DienThoai());
        model.addAttribute("nhaCungCaps", nhaCungCapService.findAll());
        return "DienThoaiForm";
    }

    @PostMapping("/them-moi-dt")
    public String addDienThoai(@ModelAttribute("dienThoai") DienThoai dienThoai,
                               @RequestParam("fileImage") MultipartFile fileImage,
                               RedirectAttributes redirectAttributes) {

        // TODO: Bổ sung logic Validation và kiểm tra lỗi (sẽ cần thêm @Valid và BindingResult)

        if (!fileImage.isEmpty()) {
            try {
                String uploadDir = "D:/HK7/JavaWWW/LAB/Tuan8/BaiTap2/src/main/webapp/img/uploads/";
                File uploadPath = new File(uploadDir);
                if (!uploadPath.exists()) {
                    uploadPath.mkdirs();
                }
                String fileName = System.currentTimeMillis() + "_" + fileImage.getOriginalFilename();
                File dest = new File(uploadPath + File.separator + fileName);
                fileImage.transferTo(dest);
                dienThoai.setHinhAnh(fileName);
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "Lỗi tải ảnh lên: " + e.getMessage());
                return "redirect:/them-moi-dt";
            }
        }
        dienThoaiService.save(dienThoai);
        redirectAttributes.addFlashAttribute("successMessage", "Thêm sản phẩm thành công!");
        return "redirect:/danh-sach-ncc";
    }
}