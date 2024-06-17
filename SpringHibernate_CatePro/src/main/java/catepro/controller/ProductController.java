package catepro.controller;

import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import catepro.dao.CategoryDAO;
import catepro.dao.ProductDAO;
import catepro.entities.Category;
import catepro.entities.Product;

@Controller

public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	@RequestMapping(value = {"/","/listProducts"})
	public String listProducts(Model model) {
		List<Product> list = productDAO.getProducts();
		model.addAttribute("list", list);
		return "listProducts";
	}

	@RequestMapping("/initInsertProduct")
	public String initIntertProduct(Model model) {
		List<Category> list = categoryDAO.getCategories();
		model.addAttribute("listCate", list);
	
		Product p = new Product();
		model.addAttribute("p", p);
		
		return "insertProduct";
	}
	
	@RequestMapping("/insertProduct")
	public String insertProduct(@ModelAttribute("p")Product pro,Model model,RedirectAttributes re) {
		boolean bl = productDAO.insertProduct(pro);
		if (bl) {
			re.addFlashAttribute("re", "Thêm thông tin thành công");
			return "redirect:/listProducts";
		}else {
			model.addAttribute("loi", "Thêm thông tin thất bại!!!");
			List<Category> list = categoryDAO.getCategories();
			model.addAttribute("listCate", list);
			
			model.addAttribute("p", pro);
			
			return "insertProduct";
		}
	}
	
	@RequestMapping("/detailProduct")
	public String detailProduct(@RequestParam("proId")Integer proId,Model model) {
		Product product = productDAO.Thongtinchitiet(proId);
		model.addAttribute("p", product);
		return "detailProduct";
	}
	
	@RequestMapping("/xoaSP")
	public String xoaSP(@RequestParam("proId")Integer proId,Model model) {
		boolean bl = productDAO.xoaSP(proId);
		if (bl) {
			model.addAttribute("s", "Xóa thành công");
		}else {
			model.addAttribute("d", "Xóa thất bại");
		}
		List<Product> list = productDAO.getProducts();
		model.addAttribute("list", list);
		return "listProducts";
	}
	
	@RequestMapping("/preCapNhapSP")
	public String preCapNhapSP(@RequestParam("proId")Integer proId,Model model) {
		List<Category> categories = categoryDAO.getCategories();
		model.addAttribute("listCate", categories);
		Product product = productDAO.Thongtinchitiet(proId);
		model.addAttribute("p", product);
		
		return "CapNhapSP";
	}
	
	@RequestMapping("/CapNhapSP")
	public String CapNhapSP(@ModelAttribute("p")Product pro,Model model,RedirectAttributes ra) {
		boolean bl = productDAO.updateProduct(pro);
		if (bl) {
			ra.addFlashAttribute("tc", "Cập nhập thành công");
			return "redirect:listProducts";
		}else {
			model.addAttribute("tb", "Cập nhập thất bại");
			model.addAttribute("p", pro);
			return"CapNhapSP";
		}
	}
	
	@RequestMapping("/seachSP")
	public String seachSP(@RequestParam("Search")String Search,Model model) {
		List<Product> list = productDAO.TimKiemSP(Search);
		model.addAttribute("list", list);
		return "listProducts";
	}
}
