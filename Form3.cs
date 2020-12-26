using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Student_Management
{
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
            toolStripStatusLabel3.Text = DateTime.Now.ToString("yyyy - MM - dd hh: mm:ss");
            timer1.Start();
        }

        private void 选课ToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void Form3_Load(object sender, EventArgs e)
        {

            toolStripStatusLabel3.Text = DateTime.Now.ToString("yyyy - MM - dd hh: mm:ss");
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            toolStripStatusLabel3.Text = DateTime.Now.ToString("yyyy - MM - dd hh: mm:ss");
        }

        private void Form3_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
            //强行结束整个程序
        }
    }
}
