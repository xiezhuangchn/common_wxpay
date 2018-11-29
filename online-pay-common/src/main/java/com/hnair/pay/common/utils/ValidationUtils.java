package com.hnair.pay.common.utils;

import com.alibaba.fastjson.JSON;
import com.hnair.pay.common.models.dto.request.pay.wx.CreateWechartWxJSAPIPayOrderRequest;
import com.hnair.pay.common.models.dto.response.ValidationResult;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



/**
 *  JSR 校验
 *  hibernate validation
 * @author bing.cheng
 *
 */
public class ValidationUtils {

	private final static Logger LOGGER = LoggerFactory.getLogger(ValidationUtils.class);
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	public static <T> ValidationResult validateEntity(T obj) {
		try {
			ValidationResult result = new ValidationResult();
			Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
			if (CollectionUtils.isNotEmpty(set)) {
				result.setHasErrors(true);
				Map<String, String> errorMsg = new HashMap<String, String>();
				for (ConstraintViolation<T> cv : set) {
					errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
				}
				result.setErrorMsg(errorMsg);
			}
			return result;
		} catch (Exception e) {
			LOGGER.error("ValidationUtils ValidationResult error, entity : {}", JSON.toJSONString(obj));
			LOGGER.error("ValidationUtils ValidationResult error", e);
		}
		return null;
	}

	//public static void main(String[] args) {
     //	AppData appData = new AppData();
	//	Variables variables = new  Variables();
	//	Credit credit = new Credit();
	//	variables.setCredit(credit);
	//	System.out.println(JSON.toJSONString(ValidationUtils.validateEntity(variables)));
	//}
    public static void main(String[] args) {
        CreateWechartWxJSAPIPayOrderRequest req = new CreateWechartWxJSAPIPayOrderRequest();
        ValidationResult validationResult = ValidationUtils.validateEntity(req);
        if(validationResult.isHasErrors()){
            System.out.println(11);
        }
        System.out.println(112);
    }
}
