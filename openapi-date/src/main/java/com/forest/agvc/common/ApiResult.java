package com.forest.agvc.common;

import com.forest.agvc.model.Result;

/**
 * Define HTTP Status code.
 *
 * @author forestyang
 * @date 1/19/2019
 */
public class ApiResult {

  private ApiResult() {
  }


  public static final Result HTTP_RESULT_SUCCESS = new Result();
  public static final Result HTTP_RESULT_FAIL = new Result();

  static {
    HTTP_RESULT_SUCCESS.setCode(200);
    HTTP_RESULT_SUCCESS.setMessage("Successful");

    HTTP_RESULT_FAIL.setCode(400);
    HTTP_RESULT_FAIL.setMessage("Failed");
  }

}
