import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";


    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put ("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/definitions", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("definitions", Definition.all());
      model.put ("template", "templates/definitions.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("definitions/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put ("template", "templates/definition-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/definitions", (request, response) -> {
      Map<String, Object> model = new HashMap <String, Object>();
      Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
      String defineWord = request.queryParams("defineWord");
      String userName = request.queryParams("userName");
      Definition newDefinition = new Definition(defineWord, userName);
      word.addDefinition(newDefinition);
      model.put("word", word);
      model.put ("template", "templates/word-definition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("definitions/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put ("template", "templates/definition-form.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
  }
}
