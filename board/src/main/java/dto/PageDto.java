package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDto {
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    private SearchDto searchDto;
    private int result;

    public PageDto(SearchDto searchDto, int result) {
        this.searchDto = searchDto;
        this.result = result;

        endPage = (int) (Math.ceil(searchDto.getPage() / 10.0)) * 10;
        // ceil = 가까운 정수로 올림
        // 3페이지 였을 경우 3 / 10.0 = ceil(0.3) => 1 * 10 => endPage = 10
        startPage = endPage - 9;

        // endPage 가 10이 맞는 지 다시 계산
        int realEnd = (int) (Math.ceil(result / 1.0) / searchDto.getAmount());

        // realEnd 보다 크면
        if (realEnd < this.endPage) {
            // realEnd 값을 endPage 로 바꿈
            this.endPage = realEnd;
        }

        // startPage 가 1보다 크면 이전으로 갈 수 있음
        this.prev = this.startPage > 1;
        // 다음 페이지로 이동 가능
        this.next = this.endPage < realEnd;
    }
}
