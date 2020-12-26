using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;

namespace Student_Management
{
    class Dao
    {
        public SqlConnection connection()
        {
            string str = "Data Source=LAPTOP-7IQE55CB;Initial Catalog=StudentDatabase;Integrated Security=True";
            SqlConnection sc = new SqlConnection(str);
            sc.Open();//打开数据库链接
            return sc;
        }
        //连接数据库的方法
        public SqlCommand command(string sql)
        {
            connection();
            SqlCommand sc = new SqlCommand(sql,connection());
            return sc;
        }
        //用于delete update insert,返回受影响的行数
        public int Excute(string sql)
        {
            return command(sql).ExecuteNonQuery();
        }
        //用于select语句，返回SqlDataReader对象，包含select到的数组
        public SqlDataReader read(string sql)
        {
            return command(sql).ExecuteReader();
        }
    }
}
