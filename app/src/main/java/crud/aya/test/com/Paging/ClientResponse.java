package crud.aya.test.com.Paging;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class ClientResponse {

        @SerializedName("data")
        private List<Client> users;
        @SerializedName("page")
        private Long page;
        @SerializedName("per_page")
        private Long perPage;
        @SerializedName("total")
        private Long total;
        @SerializedName("total_pages")
        private Long totalPages;

        public List<Client> getUsers() {
            return users;
        }

        public void setUsers(List<Client> users) {
            this.users = users;
        }

        public Long getPage() {
            return page;
        }

        public void setPage(Long page) {
            this.page = page;
        }

        public Long getPerPage() {
            return perPage;
        }

        public void setPerPage(Long perPage) {
            this.perPage = perPage;
        }

        public Long getTotal() {
            return total;
        }

        public void setTotal(Long total) {
            this.total = total;
        }

        public Long getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Long totalPages) {
            this.totalPages = totalPages;
        }
    }

