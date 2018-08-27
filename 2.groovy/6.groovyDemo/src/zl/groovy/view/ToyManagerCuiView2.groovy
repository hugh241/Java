package zl.groovy.view;
/**
 * 玩具管理命令行界面
 */

def printMenu() {
	println ''
	println '\t\tWelcome to Toy Manager View'
	println '\t\t==========================='
	print '''
		0.Exist System
		1.Add Toy
		2.Display All Toys
		3.Update Toy
		4.Delete Toy
		5.Display Toy
		6.Delete All Toys

			Please Choice:
	'''
	new BufferedReader(new InputStreamReader(System.in)).readLine()
}

def choice = printMenu()

while(choice != '0') {
	if(choice == '1') {
		println 'Add Toy'
	}else if(choice == '2') {
		println 'Display All Toys'
	}else if(choice == '3') {
		println 'Update Toy'
	}else if(choice == '4') {
		println 'Delete Toy'
	}else if(choice == '5') {
		println 'Display Toy'
	}else if(choice == '6') {
		println 'Delete All Toys'
	}else {
		println 'Do Not Have This Choice'
	}
	choice = printMenu()
}

println 'System Exist'