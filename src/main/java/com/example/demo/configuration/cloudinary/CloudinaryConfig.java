package com.example.demo.configuration.cloudinary;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter

public class CloudinaryConfig
{

    @Value("${CLOUDINARY_URL}")
    private  String cloudinaryUrl;

    @Value("${FOLDER_NAME}")
    private  String cloudinaryFolderName;

    @Value("${DEFAULT_AVATAR}")
    private  String avatarImagePath;

    @Value("${SECRETE_KEY}")
    private  String secreteKey;




}
