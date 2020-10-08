# Android-Dynamic-Layout-Add
Android Dynamic Layout Add  And Remove Layout

  minus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        try {
                            list.remove(position);
                            notifyItemRemoved(position);
                        }catch (ArrayIndexOutOfBoundsException e){e.printStackTrace();}
                    }
                });

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        try {
                            ListDataModel model=new ListDataModel("","","");
                            list.add(model);

                            // list.add(position + 1,);
                            notifyItemInserted(position + 1);
                        }catch (ArrayIndexOutOfBoundsException e){e.printStackTrace();}
                    }
                });

