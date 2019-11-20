package cn.com.scitc.client;

import cn.com.scitc.api.ItemProductQuery;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("zhahuo-item-server")
public interface SearchClient extends ItemProductQuery {
}
