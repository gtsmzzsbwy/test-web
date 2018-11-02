package com.syaccp.easybuy.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syaccp.easybuy.entity.News;
import com.syaccp.easybuy.service.NewsService;
import com.syaccp.easybuy.utils.DateUtils;

@Controller
@RequestMapping("/news")
public class NewsController {

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击

		// Date 类型转换
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(DateUtils.parseDate(text));
			}

		});
	}
	
	public NewsController() {
	}
	@Resource
	private NewsService newsService;
	
	@RequestMapping("")
	public String list(){
		List<News> news = newsService.findAll();
		for (News news2 : news) {
			System.out.println(news2.getTitle());
		}
		return "NewFile1";
	}
	
	@RequestMapping("/toFile")
	public String toFile(){
		return "NewFile";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(News news){
		System.out.println("save");
		System.out.println(news.getTitle());
		System.out.println(news.getContent());
		return "redirect:/news";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable(value="id")Integer id){
		System.out.println("delete"+id);
		return "redirect:/news";
	}
	
	@RequestMapping(value="/ajax")
	@ResponseBody
	public String ajax(@PathVariable(value="id")Integer id){
		String result = "你好啊";
		return result;
	}
	
	 //普通属性直接用user  ,多文件上载
//	@RequestMapping(value="/uploadFile2" ,method=RequestMethod.POST)
//	public String upload2(@Valid User user,BindingResult errors,MultipartRequest request){
//		List<MultipartFile> files = request.getFiles("parts");
//		List<FieldError> fieldErrors = errors.getFieldErrors();
//		for(FieldError error:fieldErrors){
//			System.out.println(error.getField());
//			System.out.println(error.getDefaultMessage());
//		}
//		
//		for(MultipartFile part:files){
//			String fileName = part.getOriginalFilename();  //文件名称
//			long size = part.getSize();
//			String name = part.getName();  //获得输入框的名称
//			String contentType = part.getContentType();
//			
//			//流复制
//			File file =new File("D:" +File.separator+fileName);
//			try {
//				InputStream inputStream = part.getInputStream();
//				
//				part.transferTo(file);
//				
//				
//			}catch (Exception e) {
//			
//				e.printStackTrace();
//			}
//			
//		}
//		
//		
//		
//		return "";
//		
//	}
	
	
}
