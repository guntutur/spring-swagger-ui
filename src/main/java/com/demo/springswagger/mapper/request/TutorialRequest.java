package com.demo.springswagger.mapper.request;

import com.demo.springswagger.data.entity.Tutorial;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "TutorialRequest", description = "some long description to be added, it actually is pretty long if you think about it")
public class TutorialRequest {
    @ApiModelProperty(name = "TutorialRequest title")
    private String title;
    @ApiModelProperty(name = "Description", notes = "put some notes for this particular field")
    private String description;
    @ApiModelProperty(name = "Category", notes = "drop down list", allowableValues = "education, economy, technology, automotive")
    private String category;
    @ApiModelProperty(name = "Published Status", notes = "boolean value", dataType = "boolean", example = "true")
    private boolean published;

    public static TutorialRequest of(Tutorial tutorial) {
        return TutorialRequest.builder()
                .title(tutorial.getTitle())
                .description(tutorial.getDescription())
                .category(tutorial.getCategory())
                .published(tutorial.isPublished())
                .build();
    }
}
