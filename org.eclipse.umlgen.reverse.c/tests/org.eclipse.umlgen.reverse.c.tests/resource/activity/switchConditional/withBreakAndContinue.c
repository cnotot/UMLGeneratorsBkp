void f() {
	int grade;
	switch (grade) {
	case 1:
		printf("A\n");
		break;
	case 2:
		printf("B\n");
		continue;
	case 3:
		printf("C\n");
		break;
	case 4:
		printf("D\n");
		continue;
	default:
		printf("F\n");
		break;
	}
}
