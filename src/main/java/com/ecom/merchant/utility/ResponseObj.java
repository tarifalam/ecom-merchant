package com.ecom.merchant.utility;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Divineit-Iftekher on 1/16/2018.
 */
@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObj {


  private String message;

  private ReturnStatus returnStatus;

  private HttpStatus status;

  private Object responseBody;


}
