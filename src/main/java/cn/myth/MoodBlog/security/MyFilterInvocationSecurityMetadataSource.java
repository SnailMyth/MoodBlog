package cn.myth.MoodBlog.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import cn.myth.MoodBlog.StringUtils;

public class MyFilterInvocationSecurityMetadataSource
		implements FilterInvocationSecurityMetadataSource, InitializingBean {

	private final static List<ConfigAttribute> NULL_CONFIG_ATTRIBUTE = null;
	
	// 资源权限集合
    private Map<RequestMatcher, Collection<ConfigAttribute>> requestMap; 
    
    //查找数据库权限和资源关系  
    private JdbcRequestMapBulider builder; 
    
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		final HttpServletRequest request = ((FilterInvocation) object).getRequest();

		Collection<ConfigAttribute> attrs = NULL_CONFIG_ATTRIBUTE;
		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
			if (entry.getKey().matches(request)) {
				attrs = entry.getValue();
				break;
			}
		}
		return attrs;
	}

	/**
	 * 获取所有的权限
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();  
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap  
                .entrySet()) {  
            allAttributes.addAll(entry.getValue());  
        }
        StringUtils.printValue(MyFilterInvocationSecurityMetadataSource.class, "All Permission", allAttributes.toString());
        return allAttributes;  
	}

    //绑定requestMap  
    protected Map<RequestMatcher, Collection<ConfigAttribute>> bindRequestMap() {  
          
        return builder.buildRequestMap();  
    } 
    

	
	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.requestMap = this.bindRequestMap();  
	}
	
    public void refreshResuorceMap() {  
        this.requestMap = this.bindRequestMap();  
    } 
    
    public JdbcRequestMapBulider getBuilder() {  
        return builder;  
    }  
      
    public void setBuilder(JdbcRequestMapBulider builder) {  
        this.builder = builder;  
    } 

}
