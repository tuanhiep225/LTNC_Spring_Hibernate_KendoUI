package mta.th12a.tuanhiep.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//khai báo annotation này có hiệu lực với method
@Target(ElementType.METHOD)
public @interface Auth {
 // ở đây mình set cứng gồm 1 số quyền sau, chúng ta có thể thay thế sang
 // String hoặc int để sử dụng kèm db
/* public enum Role {
     LOGIN, ADMIN
 };*/
 // khai báo properties cho anotation với giá trị mặc định là LOGIN
 // ví dụ: @Auth(role = Role.LOGIN)
 public int role() default 1; // default = @Auth()
}