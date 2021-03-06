package be4service2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be4service2.models.Profissional;
import be4service2.service.ProfissionalService;
import be4service2.service.ServicoService;

@RestController
@RequestMapping(value= "/profissional")

public class ProfissionalController
{

	@Autowired
   private ProfissionalService profissionalService;
	@Autowired
	private ServicoService servicoService;
		
	private List<Profissional> profissional;
	public ProfissionalController(){
		profissional=new ArrayList<Profissional>();
		//profissional.add(new Profissional(1,"aa","aa","aa"));
		//profissional.add(new Profissional(2,"bb","bb","bb"));
		//profissional.add(new Profissional(2,"cc","cc","cc"));
	}
	
   @RequestMapping(method = RequestMethod.GET)
   public List<Profissional> load()
   {
      return profissionalService.all();
   }
   
   @RequestMapping(value="/{id}",method = RequestMethod.GET)
   public Profissional findById(@PathVariable("id") Integer id)
   {
      return profissionalService.findById(id);
   }
   
/*   produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE*/
   
   
	@RequestMapping(value="/save",method = RequestMethod.POST)
	  public void save(@RequestBody Profissional profissional){
		
		   profissionalService.save(profissional);
	   }
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public void update(@RequestBody Profissional profissional){
		
		   profissionalService.update(profissional);
	 }
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void remove(@RequestBody Profissional profissional){
		   profissionalService.remove(profissional);
	 }

	@RequestMapping(value="/{id}/tornarContratante",method = RequestMethod.PUT)
	public void tornarContratante(@PathVariable("id") Integer id){
		 	profissionalService.tornarContratante(id);
	 }


	@RequestMapping(value="/servico/{id}/aceitarServico/{resposta}",method = RequestMethod.POST)
	public void aceitarServico(@PathVariable("id") Integer id,@PathVariable("resposta") Integer resposta){
		 	servicoService.aceitarServico(id,resposta);
	 }









	
	
 /*  @RequestMapping(method = RequestMethod.POST)
   public void save(@Valid Profissional profissional)
   {
    
      profissionalService.save(profissional);
      
   }*/
   
/*
   @RequestMapping("/form")
   public ModelAndView form(Profissional profissional)
   {
      ModelAndView modelAndView = new ModelAndView("profissional/form-add");
      return modelAndView;

   }

   @RequestMapping(method = RequestMethod.POST)
   public ModelAndView save(@Valid Profissional profissional, BindingResult bindingResult)
   {
      if (bindingResult.hasErrors())
      {
         return form(profissional);
      }
      profissionalService.save(profissional);
      return new ModelAndView("redirect:/profissional");
   }
*/

   
/*   
   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
   public ModelAndView load(@PathVariable("id") Integer id)
   {
      ModelAndView modelAndView = new ModelAndView("profissional/form-update");
      modelAndView.addObject("profissional", profissionalService.findById(id));
      return modelAndView;
   }

   @RequestMapping(method = RequestMethod.GET)
   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
   {
      ModelAndView modelAndView = new ModelAndView("profissional/list");
      modelAndView.addObject("paginatedList", profissionalService.paginated(page, 10));
      return modelAndView;
   }

   //just because get is easier here. Be my guest if you want to change.
   @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
   public String remove(@PathVariable("id") Integer id)
   {
      Profissional profissional = profissionalService.findById(id);
      profissionalService.remove(profissional);
      return "redirect:/profissional";
   }

   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
   public ModelAndView update(@PathVariable("id") Integer id, @Valid Profissional profissional, BindingResult bindingResult)
   {
      profissional.setId(id);
      if (bindingResult.hasErrors())
      {
         return new ModelAndView("profissional/form-update");
      }

      profissionalService.update(profissional);
      return new ModelAndView("redirect:/profissional");
   }*/
}
