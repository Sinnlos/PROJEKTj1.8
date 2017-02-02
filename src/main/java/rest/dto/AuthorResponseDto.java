package rest.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthorResponseDto {

    private List<AuthorDto> result;



    public AuthorResponseDto(List<AuthorDto> result) {
        super();
        this.result = result;
    }

    public List<AuthorDto> getResult() {
        return result;
    }

    public void setResult(List<AuthorDto> result) {
        this.result = result;
    }




}