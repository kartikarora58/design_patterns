package splitwise.DTO.Request;

import java.util.List;

public class AddExpenseRequestDTO {
    double amount;
    int groupId;
    List<UserExpenseRequestDTO> userExpenseRequestDTOList_;
    public AddExpenseRequestDTO(double amount, int groupId, List<UserExpenseRequestDTO> userExpenseRequestDTOList) {
        this.amount = amount;
        this.groupId = groupId;
        userExpenseRequestDTOList_ = userExpenseRequestDTOList;
    }
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<UserExpenseRequestDTO> getUserExpenseRequestDTOList() {
        return userExpenseRequestDTOList_;
    }

    public void setUserExpenseRequestDTOList(
            List<UserExpenseRequestDTO> userExpenseRequestDTOList) {
        userExpenseRequestDTOList_ = userExpenseRequestDTOList;
    }
}
