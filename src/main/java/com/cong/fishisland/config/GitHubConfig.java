package com.cong.fishisland.config;

import com.cong.fishisland.cache.AuthStateRedisCache;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.request.AuthGithubRequest;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Git Hub 配置
 *
 * @author cong
 * @date 2024/04/22
 */
@Configuration
public class GitHubConfig {

    @Resource
    private AuthStateRedisCache stateRedisCache;

    @Value("${github.client-id}")
    private String clientId;

    @Value("${github.client-secret}")
    private String clientSecret;

    @Value("${github.redirect-uri}")
    private String redirectUri;


    public AuthRequest getAuthRequest(){
        return new AuthGithubRequest(AuthConfig.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .redirectUri(redirectUri)
                // .scopes(AuthScopeUtils.getScopes(AuthGithubScope.values()))
                .build(), stateRedisCache);
    }
}
