package org.imooc.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.web.multipart.MultipartFile;

@JsonInclude(Include.NON_NULL)
public class AdDto  {
	private String title;
    private String img;
    private String link;
    private Long Weight;
    private MultipartFile imgFile;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

	public Long getWeight() {
		return Weight;
	}

	public void setWeight(Long weight) {
		Weight = weight;
	}
}
