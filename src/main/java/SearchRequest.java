public class SearchRequest implements RequestInterface{
    int student_id;
    int filter_distance;
    List buildings_list;

    public SearchRequest(int student_id, int filter_distance, List buildings_list) {
        this.student_id = 0;
        this.filter_distance = 0;
        this.buildings_list = buildings_list;
    }

}