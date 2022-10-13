package com.and.urlshorterner1.service.manager;

import com.and.urlshorterner1.entry.Url;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
public interface UrlManager {
    public String getUrlByKey(@NotBlank String key);
    public Url shortenUrl(@NotBlank String url);
}
