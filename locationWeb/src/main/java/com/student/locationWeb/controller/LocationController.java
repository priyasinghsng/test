package com.student.locationWeb.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.student.locationWeb.Model.Location;
import com.student.locationWeb.Repository.LocationRepository;
import com.student.locationWeb.Service.LocationService;
import com.student.locationWeb.util.EmailUtilImpl;
import com.student.locationWeb.util.ReportUtil;

@Controller
public class LocationController {
	
	@Autowired
	LocationService service;
	
	@Autowired
	LocationRepository repository;
	
	@Autowired
	EmailUtilImpl emailUtil;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext sc;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveloc")
	public ModelAndView saveLocation(@ModelAttribute Location location) {
		Location locationSaved= service.savelocation(location);
		String msg="Location saved for ID: "+locationSaved.getId();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("createLocation");
		mv.addObject("msg", msg);
		emailUtil.sendEmail("priyasingh.gvu@gmail.com", "FirstProgramSubject - Data Saved", "FirstProgramBody - Data Saved");
		return mv;
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
	 List<Location> locations=service.getAllLocation();
	 modelMap.addAttribute("locations", locations);
	 return "displayLocations";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location location=service.getLocationById(id);
		service.deleteLocation(location);
		List<Location> locations=service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location location=service.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "editLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute Location location, ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> locations=service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		
		String path = sc.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";
		
	}
}

