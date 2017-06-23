package com.expense.helper.rest.internal.dao.impl;

import static com.expense.helper.rest.util.ArgumentChecker.rejectIfNull;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.expense.helper.rest.internal.dao.ExpenseDetailsDAO;
import com.expense.helper.rest.internal.db.ExpenseHelperDBConnection;
import com.expense.helper.rest.internal.model.ExpenseDetailsImpl;
import com.expense.helper.rest.model.CategoryType;
import com.expense.helper.rest.model.ExpenseDetails;
import com.expense.helper.rest.model.SpendBy;
import com.expense.helper.rest.model.SpendOn;

public class ExpenseDetailsDAOImpl implements ExpenseDetailsDAO
{
    private static final String ADD_EXPENSE_QUERY = "INSERT INTO expense_detail (ID, STORE_DESCRIPTION, CATEGORY_TYPE, "
            + "SPEND_BY, SPEND_ON, AMOUNT, COMMENT, EXPENSE_DATETIME) VALUES(?,?,?,?,?,?,?,?)";

    @Override
    public void addExpenseDetails(ExpenseDetails expenseDetails)
    {
        rejectIfNull(expenseDetails, "expenseDetails");

        PreparedStatement preparedStatement = null;
        Connection connection = ExpenseHelperDBConnection.getConnection();

        try (Connection conn = connection)
        {
            preparedStatement = conn.prepareStatement(ADD_EXPENSE_QUERY);

            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, expenseDetails.getStoreDescription());
            preparedStatement.setString(3, expenseDetails.getCategoryType().toString());
            preparedStatement.setString(4, expenseDetails.getSpendBy().toString());
            preparedStatement.setString(5, expenseDetails.getSpendOn().toString());
            preparedStatement.setBigDecimal(6, expenseDetails.getExpenseAmount());
            preparedStatement.setString(7, expenseDetails.getComment());
            preparedStatement.setDate(8, new Date(
                    expenseDetails.getExpenseDateTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()));

            preparedStatement.executeUpdate();

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ExpenseDetails> getExpenseDetailsByMonthAndYear(int month, int year)
    {
        String sql = "SELECT STORE_DESCRIPTION, CATEGORY_TYPE, SPEND_BY, SPEND_ON, AMOUNT, COMMENT, EXPENSE_DATETIME FROM expense_detail";

        Connection connection = ExpenseHelperDBConnection.getConnection();

        try (Connection conn = connection;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql))
        {
            List<ExpenseDetails> allExpenseDetails = new ArrayList<ExpenseDetails>();

            while (rs.next())
            {
                ExpenseDetails expenseDetails = new ExpenseDetailsImpl.Builder()
                        .storeDescription(rs.getString("STORE_DESCRIPTION"))
                        .categoryType(CategoryType.valueOf(rs.getString("CATEGORY_TYPE")))
                        .spendBy(SpendBy.valueOf(rs.getString("SPEND_BY")))
                        .spendOn(SpendOn.valueOf(rs.getString("SPEND_ON"))).expenseAmount(rs.getBigDecimal("AMOUNT"))
                        .comment(rs.getString("COMMENT"))
                        .expenseDateTime(rs.getTimestamp("EXPENSE_DATETIME").toLocalDateTime()).build();

                allExpenseDetails.add(expenseDetails);
            }
            return allExpenseDetails;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
