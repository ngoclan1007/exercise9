package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductController {
      static Scanner sc = new Scanner(System.in);
      static ProductService service = new ProductService();
      static ArrayList<Product> list = service.getListProduct();
      public static void mainMenu(){

          while (true){
              menu();
              int x = sc.nextInt();
              sc.nextLine();
              switch (x){
                  case 1:
                      System.out.println("Danh sách sản phẩm");
                      service.show(list);
                      break;
                  case 2:
                      System.out.println("tìm theo tên");
                      System.out.println("nhập tên sản phẩm cần tìm");
                      String name = sc.nextLine();
                      ArrayList<Product> findProductbyName = service.findProductbyName(list,name);
                      service.show(findProductbyName);
                      break;
                  case 3:
                      System.out.println("xem sp có số lượng nhỏ hơn 5");
                      ArrayList<Product> fProductAmount5 = service.productsAmount5(list,5);
                      service.show(fProductAmount5);
                      break;
                  case 4:
                      findProductById();
                      break;
                  case 5:
                      System.out.println("thêm sản phẩm mới");
                      AddNewProduct();
                      break;
                  case 6:
                      viewProductByPrice();
                      break;
                  case 7:
                      System.out.println("lọc sản phẩm theo loại");
                      System.out.println("nhập tên sản phẩm cần tìm");
                      String type= sc.nextLine();
                      if (type.contains("houseware")){
                          ArrayList<Product> viewProductHouse = service.viewProductByTypeHouseware(list);
                          service.show(viewProductHouse);
                          break;
                      } else if(type.contains("food")){
                          ArrayList<Product> viewProductFood = service.viewProductByTypeFood(list);
                          service.show(viewProductFood);
                          break;
                      } else if(type.contains("fashion")){
                          ArrayList<Product> viewProductFashion = service.viewProductByTypeFashion(list);
                          service.show(viewProductFashion);
                          break;
                      } else {
                          System.out.println("không có loại sản phẩm này ");
                      }
                      break;
                  case 0:
                      System.out.println("thoát chương trình");
                      System.exit(0);
                      break;
                  case 9:
                      System.out.println("không có lựa chọn này ");

              }

          }

     }



    public static void findProductById(){
      System.out.println("tìm theo mã");
      System.out.println("nhập mã sản phẩm cần tìm");
      int id = sc.nextInt() ;
      sc.nextLine();
      Product findProductbyId = service.findProductbyId(list, id);
      System.out.println(findProductbyId);

      while (true){
          subMenu1();
          int x = sc.nextInt();
          sc.nextLine();
          switch (x){
              case 1:
                  if (service.deleteProduct(list,findProductbyId)){
                      System.out.println("xóa thành công");
                  };
                  break;
              case 2:
                  System.out.println("cập nhật số lượng sản phẩm");
                  System.out.println("nhập số lượng sản phẩm mới");
                  int amount = sc.nextInt();
                  service.updateAmount(findProductbyId, amount);
                  System.out.println("cập nhật thành công");
                  break;
              case 3:
                  System.out.println("cập nhật giá bán của sản phẩm");
                  System.out.println("nhập giá bán mới");
                  long price = sc.nextLong();
                  service.updatePrice(findProductbyId,price);
                  System.out.println("cập nhật giá bán thành công");
                  break;
              case 4:
                  mainMenu();
                  break;
              case 0:
                 System.exit(0);
                 break;
              default:
                  System.out.println("không có lưa chọn này ");
          }
      }
      }


      public static void  AddNewProduct(){
          System.out.println(" nhập mã sản phẩm : ");
          int id = Integer.parseInt(sc.nextLine());
          System.out.println("nhập tên sản phẩm: ");
          String nameProduct = sc.nextLine();
          System.out.println("nhập loại sản phẩm");
          TypeProduct type = chooseCategory();
          System.out.println("nhập số lượng sản phẩm");
          int amount = sc.nextInt();
          System.out.println("nhập giá bán sản phẩm");
          long price = sc.nextLong();


          Product newProduct = new Product(id,nameProduct, type,amount,price);
          if (service.addNewProduct(list, newProduct)){
              System.out.println("thêm thành công");
          } else {
              System.out.println("thêm thất bại");
          }
      }

    public static TypeProduct chooseCategory(){
        System.out.println("1 - Đồ gia dụng");
        System.out.println("2 - Thực phẩm");
        System.out.println("3 - Thời trang");
        while (true){
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    return TypeProduct.houseware;
                case 2:
                    return TypeProduct.food;
                case 3:
                    return TypeProduct.fashion;
                default:
                    System.out.println("Không có lựa chọn này, mời chọn lại: ");
            }

        }
    }

        public static void viewProductByPrice(){
            while (true){
                subMenu2();
                int x = sc.nextInt();
                sc.nextLine();
                switch (x){
                    case 1:
                        System.out.println("các sản phẩm có giá nhỏ hơn 50000");
                        ArrayList<Product> VproductByPrice50000 = service.viewProduct50000(list);
                        service.show(VproductByPrice50000);
                        break;

                    case 2:
                        System.out.println("các sản phẩm có giá từ 50000 đến dưới 100000");
                        ArrayList<Product> VproductByPrice100000 = service.viewProduct100000(list);
                        service.show(VproductByPrice100000);
                        break;
                    case 3:
                        System.out.println("các sản phẩm có giá từ 100000 đến dưới 250000");
                        ArrayList<Product> VproductByPrice250000 = service.viewProduct250000(list);
                        service.show(VproductByPrice250000);
                        break;
                    case 4:
                        System.out.println("các sản phẩm có giá từ 250000 trở lên");
                        ArrayList<Product> VproductByPriceup250000 =  service.viewProductup250000(list);
                        service.show(VproductByPriceup250000);
                        break;
                    case 5:
                        mainMenu();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("không có lựa chọn này");
                }
            }


        }
    public static void menu(){
    System.out.println("bạn có thể thực hiện");
    System.out.println("1- xem danh sách sản phẩm");
    System.out.println("2- tìm sản phẩm theo tên");
    System.out.println("3- các sản phẩm có số lượng nhỏ hơn 5");
    System.out.println("4- tim sản phẩm theo mã sản phẩm");
    System.out.println("5- thêm sản phẩm mới");
    System.out.println("6- xem sản phẩm theo mức giá");
    System.out.println("7- lọc sản phẩm theo loại");
    System.out.println("0- thoát chương trình");
      }

    public static void subMenu1(){
        System.out.println("1- xóa sản phẩm có Id trên");
        System.out.println("2-cập nhật số lượng sản phẩm ");
        System.out.println("3-cập nhật giá bán của sản phẩm");
        System.out.println("4- quay về trang chủ");
        System.out.println("0- thoát chương trình");
    }

    public static void subMenu2(){
        System.out.println("1- các sản phẩm có giá nhỏ hơn 50000");
        System.out.println("2- các sản phẩm có giá từ 50000 đến dưới 100000");
        System.out.println("3- các sản phẩm có giá từ 100000 đến dưới 250000");
        System.out.println("4- các sản phẩm có giá trên 250000");
        System.out.println("5- quay về trang chủ");
        System.out.println("0- thoát chương trình");
    }
}
