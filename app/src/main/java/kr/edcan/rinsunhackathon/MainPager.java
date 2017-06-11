package kr.edcan.rinsunhackathon;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Telephony;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static android.content.ContentValues.TAG;

/**
 * Created by bene on 2016. 7. 22..
 */
public class MainPager extends Fragment implements View.OnClickListener {
    int REQ_CODE_SELECT_IMAGE = 100;
    ImageView mBackground;
    SharedPreferences s;
    SharedPreferences.Editor editor;
    LayoutInflater inflater;
    ViewGroup container;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        View v = set();
        return v;
    }

    private View set() {
        View view = null;
        long lostDate = getDay(timeSet(), getPref("oDate").toString());
        if (lostDate >= 240) {
            Log.e(TAG, "set: 1");
            view = inflater.inflate(R.layout.activity_main1, container, false);
            ImageView mPhoneBtn = (ImageView)view.findViewById(R.id.mPhoneBtn);
            ImageView mMessageBtn = (ImageView)view.findViewById(R.id.mMessageBtn);
            ImageView mMusicBtn = (ImageView)view.findViewById(R.id.mMusicBtn);
            ImageView mCameraBtn = (ImageView)view.findViewById(R.id.mCameraBtn);
            ImageView mGalleryBtn = (ImageView)view.findViewById(R.id.mGalleryBtn);
            ImageView mBrowserBtn = (ImageView)view.findViewById(R.id.mBrowserBtn);
            mMusicBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    startActivity(intent);
                }
            });
            mPhoneBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    startActivity(intent);
                }
            });
            mMessageBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);

                    startActivity(intent);

                }
            });
            mCameraBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
                }
            });
            mGalleryBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivity(intent);
                }
            });
            mBrowserBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri= Uri.parse("http://www.naver.com"); //웹페이지와 관련된 Data는 'http:'으로 시작. 이후는 사이트의 URL
                    Intent i= new Intent(Intent.ACTION_VIEW, uri); //시스템 액티비티인 Dial Activity의 action값
                    startActivity(i);
                }
            });
        } else if (lostDate >= 180) {
            Log.e(TAG, "set: 2");
            view = inflater.inflate(R.layout.activity_main2, container, false);
            ImageView mPhoneBtn = (ImageView)view.findViewById(R.id.mPhoneBtn);
            ImageView mMessageBtn = (ImageView)view.findViewById(R.id.mMessageBtn);
            ImageView mMusicBtn = (ImageView)view.findViewById(R.id.mMusicBtn);
            ImageView mCameraBtn = (ImageView)view.findViewById(R.id.mCameraBtn);
            ImageView mGalleryBtn = (ImageView)view.findViewById(R.id.mGalleryBtn);
            ImageView mBrowserBtn = (ImageView)view.findViewById(R.id.mBrowserBtn);
            mPhoneBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    startActivity(intent);
                }
            });
            mMusicBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    startActivity(intent);
                }
            });
            mMessageBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);

                    startActivity(intent);

                }
            });
            mCameraBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
                }
            });
            mGalleryBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivity(intent);
                }
            });
            mBrowserBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri= Uri.parse("http://www.naver.com"); //웹페이지와 관련된 Data는 'http:'으로 시작. 이후는 사이트의 URL
                    Intent i= new Intent(Intent.ACTION_VIEW, uri); //시스템 액티비티인 Dial Activity의 action값
                    startActivity(i);
                }
            });
        } else if (lostDate >= 120) {
            Log.e(TAG, "set: 3");
            view = inflater.inflate(R.layout.activity_main3, container, false);
            ImageView mPhoneBtn = (ImageView)view.findViewById(R.id.mPhoneBtn);
            ImageView mMessageBtn = (ImageView)view.findViewById(R.id.mMessageBtn);
            ImageView mMusicBtn = (ImageView)view.findViewById(R.id.mMusicBtn);
            ImageView mCameraBtn = (ImageView)view.findViewById(R.id.mCameraBtn);
            ImageView mGalleryBtn = (ImageView)view.findViewById(R.id.mGalleryBtn);
            mPhoneBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    startActivity(intent);
                }
            });
            mMusicBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    startActivity(intent);
                }
            });
            mMessageBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    startActivity(intent);

                }
            });
            mCameraBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
                }
            });
            mGalleryBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivity(intent);
                }
            });
        } else if (lostDate >= 60) {
            Log.e(TAG, "set: 4");
            view = inflater.inflate(R.layout.activity_main4, container, false);
            ImageView mPhoneBtn = (ImageView)view.findViewById(R.id.mPhoneBtn);
            ImageView mMusicBtn = (ImageView)view.findViewById(R.id.mMusicBtn);

            ImageView mMessageBtn = (ImageView)view.findViewById(R.id.mMessageBtn);
            mPhoneBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    startActivity(intent);
                }
            });
            mMusicBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    startActivity(intent);
                }
            });
            mMessageBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    startActivity(intent);

                }
            });

        } else if (lostDate > 0) {
            Log.e(TAG, "set: 5");
            view = inflater.inflate(R.layout.activity_main5, container, false);
            ImageView mPhoneBtn = (ImageView)view.findViewById(R.id.mPhoneBtn);
            ImageView mMessageBtn = (ImageView)view.findViewById(R.id.mMessageBtn);

            mPhoneBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    startActivity(intent);
                }
            });
            mMessageBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);

                    startActivity(intent);

                }
            });
        } else {
            Log.e(TAG, "set: 6");
            view = inflater.inflate(R.layout.activity_main1, container, false);
        }

        ImageView mClockBtn = (ImageView) view.findViewById(R.id.mClockBtn);
        ImageView mSettingBtn = (ImageView) view.findViewById(R.id.mSettingBtn);
        mBackground = (ImageView) view.findViewById(R.id.mBackground);
        TextView dday = (TextView) view.findViewById(R.id.dday);
        CircleProgressBar cp = (CircleProgressBar) view.findViewById(R.id.cir_progress);


        mSettingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backgroundIntent = new Intent(Intent.ACTION_PICK);
                backgroundIntent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                backgroundIntent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(backgroundIntent, REQ_CODE_SELECT_IMAGE);
            }
        });

        mClockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DateActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        if (lostDate == 0) {
            dday.setText("- DAY");
            cp.setProgressWithAnimation(0);
        } else {
            if (lostDate > 360) {
                lostDate = 360;
            }
            cp.setProgressWithAnimation(360 - lostDate);
            dday.setText("- " + lostDate);
        }
        return view;
    }

    private String timeSet() {
        Calendar cal = new GregorianCalendar(Locale.KOREA);
        cal.setTime(new Date());
        SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd");
        String strNow = fm.format(cal.getTime());
        return strNow;
    }

    private long getDay(String now, String end) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        long lost = 0;
        try {
            Date st = format.parse(now);
            Date en = format.parse(end);
            long diff = en.getTime() - st.getTime();
            lost = diff / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            lost = 0;
            e.printStackTrace();
        }
        return lost;
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        String s = getActivity().getIntent().getStringExtra("cDate");
//        if (s != null) {
//            FragmentTransaction ft = getFragmentManager().beginTransaction();
//            ft.detach(this).attach(this).commit();
//        }
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), getPref("image"));
            mBackground.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE_SELECT_IMAGE) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
                SavePref(data.getData().toString());
                mBackground.setImageBitmap(bitmap);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void SavePref(String o) {
        s = getActivity().getSharedPreferences("pref", 0);
        editor = s.edit();
        editor.putString("image", o);
        editor.commit();
    }

    protected Uri getPref(String t) {
        s = getActivity().getSharedPreferences("pref", 0);
        editor = s.edit();
        String v = s.getString(t, "");
        Uri u = Uri.parse(v);
        return u;
    }
}
