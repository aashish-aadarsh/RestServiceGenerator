package com.devop.aashish.generator;

import com.devop.aashish.config.DirectoryConfig;
import com.devop.aashish.config.GeneratorConfig;
import com.devop.aashish.config.VelocityConfig;
import com.devop.aashish.constant.ApplicationConstant;
import com.devop.aashish.constant.TemplateFileConstant;
import com.devop.aashish.utility.AttributeHelper;
import com.devop.aashish.utility.PathUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class RepositoryGenerator {

    public static void generateFiles() {
        generateRepository();
    }


    private static void generateRepository() {
        String templateFileLocation = TemplateFileConstant.REPO_FILE_LOCATION;
        GeneratorConfig.DOMAIN_SET.forEach(domain -> {
            String generatedFileName = AttributeHelper.getRepositoryName(domain) + ApplicationConstant.EXTENSION_JAVA;
            new File(DirectoryConfig.PACKAGE_DIRECTORY + File.separator +
                    PathUtil.getPathFromPackageName(ApplicationConstant.PACKAGE_DOMAIN +
                            "." + AttributeHelper.getResourceAllSmallCase(domain) + "." + ApplicationConstant.PACKAGE_REPOSITORY)).mkdirs();
            String generatedFileDirectory = DirectoryConfig.PACKAGE_DIRECTORY + File.separator +
                    PathUtil.getPathFromPackageName(ApplicationConstant.PACKAGE_DOMAIN +
                            "." + AttributeHelper.getResourceAllSmallCase(domain) + "." + ApplicationConstant.PACKAGE_REPOSITORY) + File.separator + generatedFileName;
            Map<String, String> paramMap = getValues(domain);
            new VelocityConfig().initWriting(paramMap, generatedFileDirectory, templateFileLocation);
        });
    }


    private static Map<String, String> getValues(String domain) {
        Map<String, String> param = new HashMap<>();
        param.put(TemplateFileConstant.KEY_PACKAGE_ID, GeneratorConfig.PACKAGE_ID);
        param.put(TemplateFileConstant.KEY_RESOURCE_NAME_SINGULAR, AttributeHelper.getSingularResource(domain));
        param.put(TemplateFileConstant.KEY_RESOURCE_NAME_PLURAL, AttributeHelper.getPluralResource(domain));
        param.put(TemplateFileConstant.KEY_RESOURCE_NAME_SMALL_CASE, AttributeHelper.getResourceSmallCase(domain));
        param.put(TemplateFileConstant.KEY_RESOURCE_NAME_ALL_SMALL_CASE, AttributeHelper.getResourceAllSmallCase(domain));
        param.put(TemplateFileConstant.KEY_RESOURCE_NAME_API, AttributeHelper.getResourceNameAPI(domain));
        return param;
    }
}