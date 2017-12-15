
package com.zhiqin.module;

import com.zhiqin.module.utils.VaildatMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

/**
 * 处理web内部出错给用户以有好提示处理
 *
 * @author lyf
 */
@ControllerAdvice
public class WebExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(WebExceptionHandler.class);

    @Autowired
    private MessageSource msgSource;

    /**
     * 处理用户上传参数验证信息
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public VaildatMsg processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        FieldError error = result.getFieldError();
        log.info("");
        return processFieldError(error);
    }

    /**
     * 处理用户上传文件出错
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MultipartException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public VaildatMsg fileSizeLimitError(MultipartException ex) {
        return new VaildatMsg(-1, ex.getMessage());
    }

    private VaildatMsg processFieldError(FieldError error) {
        VaildatMsg message = null;
        if (error != null) {
            String msg = msgSource.getMessage(error.getDefaultMessage(), null, LocaleContextHolder.getLocale());
            message = new VaildatMsg(-1, msg);
        }
        return message;
    }
}