package com.forest.agvc.api;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * @author forestyang
 * @date 1/14/2019
 */
public class ApiUtil {

  private ApiUtil() {
  }

  public static void setExampleResponse(NativeWebRequest req, String contentType, String example) {
    try {
      HttpServletResponse res = req.getNativeResponse(HttpServletResponse.class);
      res.setCharacterEncoding("UTF-8");
      res.addHeader("Content-Type", contentType);
      res.getWriter().print(example);
    } catch (IOException e) {
      throw new ExampleException(e);
    }
  }

  public static class ExampleException extends RuntimeException {

    ExampleException(Throwable cause) {
      super(cause);
    }
  }
}