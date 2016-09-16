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
      model.put("words", Word.all());
      model.put("template", "templates/words.vtl");
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
      Definition newDefinition = new Definition(defineWord);
      word.addDefinition(newDefinition);
      model.put("word", word);
      model.put ("template", "templates/word-definition.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    get("/definitions/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Definition definition = Definition.find(Integer.parseInt(request.params(":id")));
      model.put("definition", definition);
      model.put ("template", "templates/definition.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    get("/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/word-form.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String setWord = request.queryParams("setWord");
      Word newWord = new Word(setWord);
      model.put("template", "templates/word-success.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    get("/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    get("/:id/definitions/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/word-definitions-form.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
  }
}
